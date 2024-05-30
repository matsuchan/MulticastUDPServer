import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class kadaiMulticastClient {
    public static void main(String[] args) {
        try {
            // 自分のPC内でやる場合
            InetAddress group = InetAddress.getByName("224.0.0.1");
            int port = 2525;
            // データ送信用のソケットを作成
            DatagramSocket socket = new DatagramSocket();
            // 送信するメッセージを設定
            String command = "こんにちはサーバーさん";
            // コマンドをバイト配列に変換して DatagramPacket を作成し、マルチキャストグループに送信
            byte[] buffer = command.getBytes();
            //パケットの作成
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            //ソケットにパケットを送信
            socket.send(packet);
            //サーバーに送ったメッセージをひょうじ
            System.out.println("送信したメッセージ: " + command);

            // ソケットを閉じる
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
