import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class PortConnectUtil extends Application {
    private TextArea result = new TextArea();
    private TextField targetIP = new TextField();
    private TextField startPort = new TextField();
    private TextField endPort = new TextField();
    private Button scan = new Button("扫描");
    private Button quickScan = new Button("快速扫描");
    private Button threadScan = new Button("多线程扫描");
    private Button ex = new Button("退出");
    private Button stop = new Button("停止扫描");
    private Thread readThread;
    static AtomicInteger portCount;//用于统计已扫描的端口数量

    private ProgressBar progressBar = new ProgressBar();
    private Label bar = new Label("0%");

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainPane = new BorderPane();

        HBox barBox = new HBox();
        barBox.setSpacing(10);
        barBox.setPadding(new Insets(10, 0, 10, 0));
        progressBar.setPrefWidth(700);
        progressBar.setProgress(0);
        HBox.setHgrow(progressBar, Priority.ALWAYS);
        barBox.getChildren().addAll(bar, progressBar);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10, 20, 10, 20));
//        vBox.setAlignment(Pos.CENTER);
        VBox.setVgrow(result, Priority.ALWAYS);
        vBox.getChildren().addAll(new Label("端口扫描结果："), result, barBox);
        mainPane.setCenter(vBox);

        startPort.setPrefWidth(60);
        endPort.setPrefWidth(60);
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setPadding(new Insets(10, 20, 10, 20));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(new Label("目标主机ip："), targetIP, new Label("起始端口号："), startPort, new Label("结束端口号："), endPort);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.setPadding(new Insets(10, 20, 10, 20));
        hBox2.setAlignment(Pos.CENTER);

        hBox2.getChildren().addAll(scan, quickScan, threadScan, stop, ex);

        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setPadding(new Insets(10, 20, 10, 20));
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(hBox1, hBox2);
        mainPane.setBottom(vBox1);

        Scene scene = new Scene(mainPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PortScannerFX");
        primaryStage.show();


        //扫描
        scan.setOnAction(event -> {
            String host = targetIP.getText().trim();
            int sp = Integer.parseInt(startPort.getText());
            int ep = Integer.parseInt(endPort.getText());
            readThread = new Thread(() -> {

                double num = 0.0;
                for (int i = sp; i <= ep; i++) {
                    int port = i;
                    if (readThread.isInterrupted()) {
                        readThread.interrupt();
//                        Thread.interrupted();
                        break;
                    }
                    try {
                        Socket socket = new Socket(host, port);
                        socket.close();
                        Platform.runLater(() -> {
                            result.appendText("端口 " + port + " is open.\n");
                        });
                    } catch (IOException e) {
                        result.appendText("端口 " + port + " is closed.\n");
                    }
                    num++;
                    double finalNum = num;
                    Platform.runLater(() -> {
                        progressBar.setProgress(finalNum / (ep - sp + 1));//进度条
                        bar.setText("" + Integer.valueOf((int) (finalNum / (ep - sp + 1) * 100)) + "%");
                    });
                }
                result.appendText("端口扫描结束！\n");
            }, "scanThread");
            readThread.start();

        });

        //快速扫描
        quickScan.setOnAction(event -> {
            String host = targetIP.getText().trim();
            int sp = Integer.parseInt(startPort.getText());
            int ep = Integer.parseInt(endPort.getText());
            readThread = new Thread(() -> {

                double num = 0;
                for (int i = sp; i <= ep; i++) {
                    if (readThread.isInterrupted()) {
                        readThread.interrupt();
//                        Thread.interrupted();
                        break;
                    }
                    int port = i;
                    try {
                        Socket socket = new Socket();
                        socket.connect(new InetSocketAddress(host, port), 200);

                        socket.close();
                        Platform.runLater(() -> {
                            result.appendText("端口 " + port + " is open.\n");
                        });
                    } catch (IOException e) {
                        result.appendText("端口 " + port + " is closed.\n");
                    }
                    num++;
                    double finalNum = num;
                    Platform.runLater(() -> {
                        progressBar.setProgress(finalNum / (ep - sp + 1));//进度条
                        bar.setText("" + Integer.valueOf((int) (finalNum / (ep - sp + 1) * 100)) + "%");
                    });
                }
                result.appendText("端口扫描结束！\n");
            }, "scanThread");
            readThread.start();
        });

        threadScan.setOnAction(event -> {
            result.setText("");
            targetIP.getText();
            if (targetIP.getText().trim() != "") {
                result.appendText("ip地址不能为空");
                return;
            }
            if (startPort.getText().trim() != "") {
                result.appendText("起始端口不能为空");
                return;
            }
            if (endPort.getText().trim() != "") {
                result.appendText("结束端口不能为空");
                return;
            }
            portCount = new AtomicInteger(0);
            int sp = Integer.parseInt(startPort.getText());
            int ep = Integer.parseInt(endPort.getText());
            for (int i = 0; i < 100; i++) {
                readThread = new Thread(new ScanHandler(i, 100), "scanThread");
                readThread.start();
            }
        });

        stop.setOnAction(event -> {
            interrupt("scanThread");
        });

        //退出
        ex.setOnAction(event -> {
            exit();
        });
        primaryStage.setOnCloseRequest(event -> {
            exit();
        });
    }

    public void interrupt(String threadName) {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        Thread[] lstThreads = new Thread[noThreads];
        currentGroup.enumerate(lstThreads);
        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals(threadName))
                lstThreads[i].interrupt();
        }
    }

    public void exit() {
        System.exit(0);
    }


    class ScanHandler implements Runnable {
        private int totalThreadNum;//用于端口扫描的总共线程数量，默认为10
        private int threadNo;//线程号，表示第几个线程
        private int startP = Integer.parseInt(startPort.getText());
        private int endP = Integer.parseInt(endPort.getText());
        private String host = targetIP.getText().trim();

        public ScanHandler(int threadNo) {
            this.totalThreadNum = 10;
            this.threadNo = threadNo;
        }

        public ScanHandler(int threadNo, int totalThreadNum) {
            this.totalThreadNum = totalThreadNum;
            this.threadNo = threadNo;
        }

        @Override
        public void run() {
            //startPort和endPort为成员变量，表示需要扫描的起止端口
            for (int i = startP + threadNo; i <= endP; i = i + totalThreadNum) {
                int port = i;
                if (readThread.isInterrupted()) {
                    readThread.interrupt();
                    break;
                }
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(host, port), 200);
                    socket.close();
                    Platform.runLater(() -> {
                        result.appendText("端口 " + port + " is open.\n");
                    });
                } catch (IOException e) {
//                    result.appendText("端口 " +i+ " is closed.\n");
                }
                portCount.incrementAndGet();
                Platform.runLater(() -> {
                    bar.setText("" + Integer.valueOf((int) ((portCount.doubleValue()) / (endP - startP + 1) * 100)) + "%");//进度比
                    progressBar.setProgress((portCount.doubleValue()) / (endP - startP + 1));//进度条
                });
            }
            if (portCount.get() == (endP - startP + 1)) {//判断扫描结束
                portCount.incrementAndGet();
                Platform.runLater(() -> {
                    result.appendText("\n-------------多线程扫描结束-------------\n");
                });
            }
        }
    }


    public static void main(String[] args) {
        launch();
    }
}
 
 