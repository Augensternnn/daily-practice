import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangmingming  braveheart1115@163.com
 * @date 2019年10月16日 17:54
 * @Description: 英译汉服务器
 */
public class UdpDictServer {


    public static void main(String[] args) throws Exception {
        new UdpDictServer().start();
    }

    // 定义udp端口号
    public static final int PORT = 30000;
    // 每个数据报最大为4K
    private static final int DATA_LEN = 4096;
    // 接收网络数据的字节数组
    byte[] buff_in = new byte[DATA_LEN];
    // 以指定字节数组创建准备接受数据的DatagramPacket对象
    private DatagramPacket packet_in = new DatagramPacket(buff_in, buff_in.length);

    // 定义一个用于发送的DatagramPacket对象
    private DatagramPacket packet_out;

    public void start() throws Exception {
        try(DatagramSocket socket = new DatagramSocket(PORT)){
            String key = null;  // 客户端输入的英文单词
            String value=null;  // 服务端翻译的中文内容
            SocketAddress address=null; // 获取客户端对象,通过该对象将数据写给对方，否则没有目的地
            byte[] reviceData=null; // 返回给客户端的数据
            System.out.println("英译汉服务器启动了......");
            while (true){
                // 读取socket中的数据，然后将数据封装到 packet_in 中
                socket.receive(packet_in);
                // 获取客户端输入的数据
                buff_in=packet_in.getData();
                // 将byte数组转换为字符串  需要去掉后面的空格
                key=new String(buff_in,0,buff_in.length).trim();

                // 根据map的key获取value
                value=maps.get(key);
                if(null == value){
                    value="默认值";
                }
                address=packet_in.getSocketAddress();
                // 检查退出条件
                if("down".equals(key)){
                    System.out.println("客户端输入的是:"+key);
                    reviceData="服务器关闭了，请重试".getBytes();
                    packet_out=new DatagramPacket(reviceData,reviceData.length,address);
                    socket.send(packet_out);
                    break;
                }else {
                    System.out.println("客户端输入的是:"+key+",翻译后的结果是"+value);
                    // 构建服务端发送给客户端的数据
                    reviceData=("你输入的英文单词翻译成中文是:"+value).getBytes();
                    // 构建 packet_out 发送数据
                    packet_out=new DatagramPacket(reviceData,reviceData.length,address);
                    socket.send(packet_out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=====服务器关闭=====");
        }
    }

    // 定义map集合，用来存放需要翻译的单词。
    private static Map<String, String> maps = new HashMap<>();
    // 向map中添加数据
    static {
        maps.put("dog", "狗");
        maps.put("cat", "猫");
        maps.put("fish", "鱼");
        maps.put("bird", "鸟");
        maps.put("pig", "猪");
    }
}
