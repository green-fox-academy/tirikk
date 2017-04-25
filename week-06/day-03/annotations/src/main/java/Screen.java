import java.lang.annotation.Inherited;

@Inherited
@interface Monitor {
  String aspectRatio() default "4:3";
  String classification() default "TFT";
}

@Monitor
public class Screen {
  int resolutionWidth;
  int resolutionHeight;
  Size size;

  Screen() {
    size = Size.returnSize();
  }
}
