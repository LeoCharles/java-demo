package demo09;

/**
 * IO 流
 *
 * IO 是指 Input/Output，即输入和输出。以内存为中心：
 * Input 输入，从外部读入数据到内存。例如，把文件从磁盘读取到内存，从网络读取数据到内存等等。
 * Output 输出，把数据从内存输出到外部。例如，把数据从内存写入到文件，把数据从内存输出到网络等等。
 *
 * 因为代码是在内存中运行的，所以数据也必须读到内存，代码才能处理这些数据。
 * 因为内存有“易失性”的特点，所以必须把处理后的数据以某种方式输出，例如，写入到文件。
 *
 * IO 流是一种顺序读写数据的模式，特点是单向流动。数据类似自来水一样在水管中流动，称为IO流。
 * IO 流以字节(byte)为最小单位，也称为字节流。
 *
 * InputStream 字节输入流，把字节从磁盘文件读入内存
 * OutputStream 字节输出流，把字节从内存写入磁盘文件
 *
 * 如果读写的是字符(char)，这种流称为字符流。
 * Reader 字符输入流
 * Writer 字符输出流
 *
 * Reader 和 Writer本质上是一个能自动编解码的 InputStream 和 OutputStream。
 *
 * 1个字符 = 2个字节，1个字节 = 8个二进制位。
 *
 * 同步 IO 是指，读写 IO 时，代码必须等待数据返回后才继续执行后续代码
 * 优点：代码编写简单；缺点：CPU执行效率低。
 *
 * 异步 IO 是指，读写 IO 时仅发出请求，然后立刻执行后续代码。
 * 优点：CPU执行效率高，缺点：代码编写复杂。
 *
 * java.io 提供了同步 IO，而 java.nio 则是异步 IO
 *
 * InputStream、OutputStream、Reader 和 Writer 都是同步 IO 的抽象类
 *
 *
 *
 *
 */
public class MainIO {
    public static void main(String[] args) {

    }
}
