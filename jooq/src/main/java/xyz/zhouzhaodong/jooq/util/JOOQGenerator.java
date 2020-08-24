package xyz.zhouzhaodong.jooq.util;

import org.jooq.codegen.GenerationTool;
import org.jooq.codegen.JavaGenerator;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generate;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;

/**
 * 代码生成器
 *
 * @author zhouzhaodong
 */
public class JOOQGenerator extends JavaGenerator {


    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://IP地址:3306/jooq?useUnicode=true&characterEncoding=utf8";
    private static final String JDBC_USERNAME = "用户名";
    private static final String JDBC_PASSWORD = "密码";

    private static final String JOOQ_DATABASE_NAME = "org.jooq.meta.jdbc.JDBCDatabase";

    private static final String GENERATOR_PATH = "src/main/java";

    public static void genTables(String schemaName, String packageName, String includes, String excludes) throws Exception {

        Jdbc jdbc = createJdbc();
        Generator generator = createGenerator(schemaName, packageName, includes, excludes);

        Configuration configuration = new Configuration()
                .withJdbc(jdbc)
                .withGenerator(generator);

        GenerationTool.generate(configuration);

    }

    private static Generator createGenerator(String schemaName, String packageName, String includes, String excludes) {

        Database database = createDatabase(schemaName, includes, excludes);
        Target target = createTarget(packageName);
        Generate generate = createGenerate();

        return new Generator()
                .withDatabase(database)
                .withTarget(target)
                .withGenerate(generate);
    }

    private static Jdbc createJdbc() {
        return new Jdbc()
                .withDriver(JDBC_DRIVER)
                .withUrl(JDBC_URL)
                .withUser(JDBC_USERNAME)
                .withPassword(JDBC_PASSWORD);
    }

    private static Target createTarget(String packageName) {

        return new Target().withDirectory(GENERATOR_PATH).withPackageName(packageName);
    }

    private static Database createDatabase(String schemaName, String includes, String excludes) {
        Database database = new Database().withName(JOOQ_DATABASE_NAME).withInputSchema(schemaName);
        if (includes != null && !"".equals(includes)) {
            database.withIncludes(includes);
        }

        if (excludes != null && !"".equals(excludes)) {
            database.withExcludes(excludes);
        }
        return database;
    }

    private static Generate createGenerate() {
        Generate generate = new Generate();
        generate.withDaos(false)
                .withPojos(true);
        return generate;
    }

    private static void generate() throws Exception {
        genTables("jooq", "xyz.zhouzhaodong.jooq.code", ".*", "");
    }

    public static void main(String[] args) throws Exception {
        generate();
    }

}
