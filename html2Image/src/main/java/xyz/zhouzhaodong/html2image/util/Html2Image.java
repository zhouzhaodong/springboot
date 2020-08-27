package xyz.zhouzhaodong.html2image.util;

import gui.ava.html.image.generator.HtmlImageGenerator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * html转图片
 *
 * @author zhouzhaodong
 */
public class Html2Image {


    /**
     * HTML转Image
     *
     * @param fileAddress 生成图片的地址
     * @return 希望生成的Image Location
     */
    public static String html2Img(String fileAddress) {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        try {
            String htmlText = getHtmlContent();
            imageGenerator.loadHtml(htmlText);
            Thread.sleep(500);
            imageGenerator.getBufferedImage();
            Thread.sleep(1500);
            imageGenerator.saveAsImage(fileAddress);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("将HTML文件转换成图片异常");
        }
        return fileAddress;
    }

    /**
     * HTML转InputStream
     *
     * @param htmText HTML文本字符串
     * @return 希望生成的Image Location
     */
    public static InputStream html2InputStream(String htmText) {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        InputStream inputStream;
        try {
            imageGenerator.loadHtml(htmText);
            Thread.sleep(100);
            BufferedImage bufferedImage = imageGenerator.getBufferedImage();
            Thread.sleep(200);
            inputStream = bufferedImageToInputStream(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return inputStream;
    }

    /**
     * 将BufferedImage转换为InputStream
     *
     * @param bufferedImage
     * @return
     */
    public static InputStream bufferedImageToInputStream(BufferedImage bufferedImage) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", os);
            return new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @Description 转换成24位图的BMP
     * @param image
     * @return
     */
    public static BufferedImage transformGray24BitMap(BufferedImage image){

        int h = image.getHeight();
        int w = image.getWidth();
        // 定义数组，用来存储图片的像素
        int[] pixels = new int[w * h]; 
        int gray;
        PixelGrabber pg = new PixelGrabber(image, 0, 0, w, h, pixels, 0, w);
        try {
            pg.grabPixels(); // 读取像素值
        } catch (InterruptedException e) {
            throw new RuntimeException("转换成24位图的BMP时，处理像素值异常");
        }

        // 扫描列 
        for (int j = 0; j < h; j++){  
            // 扫描行
            for (int i = 0; i < w; i++) { 
                // 由红，绿，蓝值得到灰度值
                gray = (int) (((pixels[w * j + i] >> 16) & 0xff) * 0.8);
                gray += (int) (((pixels[w * j + i] >> 8) & 0xff) * 0.1);
                gray += (int) (((pixels[w * j + i]) & 0xff) * 0.1);
                pixels[w * j + i] = (255 << 24) | (gray << 16) | (gray << 8) | gray;
            }
        }

        MemoryImageSource s= new MemoryImageSource(w,h,pixels,0,w);
        Image img = Toolkit.getDefaultToolkit().createImage(s);
        //如果要转换成别的位图，改这个常量即可
        BufferedImage buf = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        buf.createGraphics().drawImage(img, 0, 0, null);
        return buf;
    }

    /**
     * 生成html字符串
     *
     * @return
     */
    public static String getHtmlContent() {
        // 需要先进行查询相关数据，然后进行拼接
        String htmlText = "<html>\n";
        htmlText += "<head>\n";
        htmlText += "</head>\n";
        htmlText += "<body>\n";
        htmlText += "<div class=\"logImg\" style=\"margin:0;left:0;top:2px;text-align: center;width: 350px;\">\n";
        // 注：图片src不支持相对路径，必须加上file:/// 或者直接写http的url。
        htmlText += "    <img align=\"middle\" src=\"https://pics3.baidu.com/feed/fd039245d688d43f57e5e274f47fe21c0ff43b54.jpeg?token=e6e076b7fa492c108a5b08805e35f8f0\">\n";
        htmlText += "</div>\n";
        htmlText += "<div class=\"contentText\" style=\"margin:20px 0 0 0\">\n";
        htmlText += "    <table border=\"0\" style=\"width: 350px;\">\n";
        htmlText += "        <tbody>\n";
        htmlText += "        <tr>\n";
        htmlText += "            <td align=\"middle\" style=\"font-size:20px\">导出测试</td>\n";
        htmlText += "        </tr>\n";
        htmlText += "        </tbody>\n";
        htmlText += "    </table>\n";
        htmlText += "</div>\n";
        htmlText += "</body>\n";
        htmlText += "</html> \n";

        return htmlText;
    }

}
