import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class kadaiMulticastServer {
    public static void main(String[] args) {
        try {
            // マルチキャストグループのIPアドレスとポート番号を指定
            InetAddress group = InetAddress.getByName("224.0.0.1");
            int port = 2525;

            // マルチキャストソケットを作成し、指定したグループとポートに参加
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group); // マルチキャストグループに参加
            //待機中のメッセージ
            System.out.println("クライアントからのメッセージを待っています...");
            // 受信用のバッファを作成
            byte[] buffer = new byte[256];
            //パケット作成
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            // コマンドを受信して永遠に待機
            while (true) {
                multicastSocket.receive(packet);
                String receivedCommand = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received command: " + receivedCommand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
