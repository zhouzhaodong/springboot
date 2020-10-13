package xyz.zhouzhaodong.springbootjapidocs.config;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @author zhouzhaodong
 */
public class JapidocsConfig {

    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath("D:\\work\\workSpace\\springboot\\spring-boot-japidocs");
        // 项目名称
        config.setProjectName("springbootjapidocs");
        // 声明该API的版本
        config.setApiVersion("V1.0");
        // 生成API 文档所在目录
        config.setDocsPath("D:\\");
        // 配置自动生成
        config.setAutoGenerate(Boolean.TRUE);
        // 执行生成文档
        Docs.buildHtmlDocs(config);
    }

}
