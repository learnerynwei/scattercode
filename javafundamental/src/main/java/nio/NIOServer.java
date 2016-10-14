package nio;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.Channels;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.nio.ByteBuffer;

//http://weixiaolu.iteye.com/blog/1479656?page=2#comments
public class NIOServer {
  // 通道管理器
  private Selector selector;

  /*
   * 获得一个ServerSocket通道，并对该通道做一些初始化的工作
   * 
   * @param port 绑定的端口号
   * 
   * @throws IOException
   */
  public void initServer(int port) throws IOException {
    // 获得一个ServerSocket通道
    ServerSocketChannel serverChannel = ServerSocketChannel.open();
    // 设置通道为非阻塞
    serverChannel.configureBlocking(false);
    // 将该通道对应的ServerSocket绑定到port端口
    serverChannel.socket().bind(new InetSocketAddress(port));
    // 获得一个通道管理器
    this.selector = Selector.open();
    // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
    // 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
    serverChannel.register(selector, SelectionKey.OP_ACCEPT);
  }

  /*
   * 采用轮询的方式监听selector上是否有需要处理的时间，如果有，则进行处理
   * 
   * @throws IOException
   */
  public void listen() throws IOException {
    System.out.println("服务器启动成功！");
    // 轮询访问selector
    while (true) {
      // 当注册的时间到达时，方法返回；否则，该方法会一直阻塞
      selector.select();
      // 获得selector中选中的项的迭代器，选中的项为注册的事件
      Iterator ite = this.selector.selectedKeys().iterator();
      while (ite.hasNext()) {
        SelectionKey key = (SelectionKey) ite.next();
        ite.remove();
        // 客户端请求连接事件
        if (key.isAcceptable()) {
          ServerSocketChannel server = (ServerSocketChannel) key.channel();
          SocketChannel channel = server.accept();
          channel.configureBlocking(false);

          channel.write(ByteBuffer.wrap(new String("Sent the message back to client!").getBytes()));
          channel.register(this.selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
          read(key);
        }
      }
    }
  }

  public void read(SelectionKey key) throws IOException {
    SocketChannel channel = (SocketChannel) key.channel();
    ByteBuffer buffer = ByteBuffer.allocate(10);
    channel.read(buffer);
    byte[] data = buffer.array();
    String msg = new String(data).trim();
    System.out.println("服务端收到信息：" + msg);
    ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
    channel.write(outBuffer);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    NIOServer server = new NIOServer();
    try {
      server.initServer(8000);
      server.listen();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
