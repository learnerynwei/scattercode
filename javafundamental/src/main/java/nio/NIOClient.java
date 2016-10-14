package nio;

import java.util.Iterator;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOClient {
  private Selector selector;

  public void initClient(String ip, int port) throws IOException {
    SocketChannel channel = SocketChannel.open();
    channel.configureBlocking(false);
    this.selector = Selector.open();
    channel.connect(new InetSocketAddress(ip, port));
    channel.register(selector, SelectionKey.OP_CONNECT);
  }

  /**
   * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
   * 
   * @throws IOException
   */
  @SuppressWarnings("unchecked")
  public void listen() throws IOException {
    // 轮询访问selector
    while (true) {
      selector.select();
      // 获得selector中选中的项的迭代器
      Iterator ite = this.selector.selectedKeys().iterator();
      while (ite.hasNext()) {
        SelectionKey key = (SelectionKey) ite.next();
        // 删除已选的key,以防重复处理
        ite.remove();
        // 连接事件发生
        if (key.isConnectable()) {
          SocketChannel channel = (SocketChannel) key.channel();
          // 如果正在连接，则完成连接
          if (channel.isConnectionPending()) {
            channel.finishConnect();
          }
          // 设置成非阻塞
          channel.configureBlocking(false);

          // 在这里可以给服务端发送信息哦
          channel.write(ByteBuffer.wrap(new String("Send a message to server!").getBytes()));
          // 在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
          channel.register(this.selector, SelectionKey.OP_READ);

          // 获得了可读的事件
        } else if (key.isReadable()) {
          read(key);
        }

      }

    }
  }

  /**
   * 处理读取服务端发来的信息 的事件
   * 
   * @param key
   * @throws IOException
   */
  public void read(SelectionKey key) throws IOException {
    // 和服务端的read方法一样
    SocketChannel channel = (SocketChannel) key.channel();
    ByteBuffer buffer = ByteBuffer.allocate(10);
    channel.read(buffer);
    byte[] data = buffer.array();
    String msg = new String(data).trim();
    System.out.println("客户端收到信息：" + msg);
    ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
    channel.write(outBuffer);
  }

  /**
   * 启动客户端测试
   * 
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    NIOClient client = new NIOClient();
    client.initClient("localhost", 8000);
    client.listen();
  }
}
