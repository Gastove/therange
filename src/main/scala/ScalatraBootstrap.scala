import com.gastove.the_range._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new RangeServlet, "/*")
    context.mount(new AboutServlet, "/about/*")
    context.mount(new PrototypeServlet, "/prototype/*")
  }
}
