package tankWar.gameView;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JFrame;

public class TestPaint extends JFrame {

    private static final long serialVersionUID = 1L;

    // 用于存储图片
    Image image;

    // 俗称的帆布啦，做手机开发的话很常见
    Canvas canvas = new Canvas() {

        private static final long serialVersionUID = 1L;

        /**
         * 绘制图像，直接调用update方法（顺便说一下，若以paint调用update,
         * 再用update调用paint，会出现很好玩的事。^^）
         */
        public void paint(Graphics g) {
            update(g);
        }

        /**
         * 此方法仅在在发生变更时绘制图形
         */
        public void update(Graphics g) {
            // 参数分别为加载图像，所在Graphics上的left,所在top,图像width,图像height,目标对象
            g.drawImage(image, getWidth() / 2 - image.getWidth(null) / 2,
                    getHeight() / 2 - image.getHeight(null) / 2, image.getWidth(null), image.getHeight(null), this);
        }
    };

    public TestPaint() {
        setTitle("图像变换");
        setSize(400, 400);
        // 设定背景为黑色
        setBackground(Color.BLACK);
    
        // 直接以class路径读取图片资源
        //URL imageUrl = getClass().getResource("gameImage/gameHelp.png");
        // 获取image图像实体
        image = Toolkit.getDefaultToolkit().createImage("gameImage/gameHelp.png");
        // 加载帆布作为背景
        add(canvas);
        class AnimeMouseListener extends MouseAdapter {
            // 鼠标进入变更
            public void mouseEntered(MouseEvent e) {
                // 顺便说一下，水平反转图的效果，是可以用代码做到的，后面讲解。
                image = Toolkit.getDefaultToolkit().createImage("gameImage/stop2.png");
                canvas.repaint();
            }

            // 鼠标离开变更
            public void mouseExited(MouseEvent e) {
                image = Toolkit.getDefaultToolkit().createImage("gameImage/stop1.png");
                canvas.repaint();
            }
        }
        
        //在帆布上添加鼠标监听
        canvas.addMouseListener(new AnimeMouseListener());
    }

    /**
     * 主函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 实例化本类
        TestPaint sa = new TestPaint();
        // 显示窗体
        sa.setVisible(true);
    }
}
