package xyz.zhouzhaodong.www.qrcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.www.qrcode.config.QRCodeGenerator;

/**
 * 生成二维码
 * @author zhouzhaodong
 */
@RestController
public class QRCodeController {

    /**
     * 生成二维码图片并将地址回传给前端
     * @param orderNo
     * @return
     */
    @RequestMapping("/qrcode/image")
    public String qrcodeImage(String orderNo) {
        String failPath = "src/main/resources/png/" + orderNo + ".png";
        try {
            QRCodeGenerator.generateQRCodeImage(orderNo, 350, 350,  failPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return failPath;
    }

    /**
     * 生成二维码Base64回传给前端
     * @param orderNo
     * @return
     */
    @RequestMapping("/qrcode/base64")
    public String qrcodeBase64(String orderNo) {
        String message = "";
        try {
            message = QRCodeGenerator.writeToStream(orderNo, 350, 350);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

}
