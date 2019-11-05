package test.one.two.a;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-11 9:22
 */
public class StribTest {

        public static void main(String[] args) {
            //说明: 将文章中英文下输入的句号 替换 成中文下输入的句号
            String article="草原下面马儿跑,我们的祖国是草原. 草原的花朵真鲜艳.";
            System.out.println(article);
            article=article.replace('.','。');
            System.out.println(article);

            article=article.replace("草原","花园");
            System.out.println(article);

            article=article.replaceFirst("花园","草原");
            System.out.println(article);

            String time = "2019-08-11";
            String[] a = time.split("-");
            StringBuffer sb = new StringBuffer();
            for (String s : a) {
                System.out.println(s);
                sb.append(s);
            }
            System.out.println(sb.toString());


        }
}
