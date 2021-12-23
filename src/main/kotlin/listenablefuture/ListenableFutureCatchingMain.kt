import com.google.common.util.concurrent.Futures
import java.lang.Thread.sleep
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newWorkStealingPool(2)
  val future = Futures.submit<String>({
    throw IllegalArgumentException("Bla Bla")
  }, executor)

  Futures.catching(future, IllegalArgumentException::class.java, {
    println(it.message)
  }, executor)

  sleep(1000)

  executor.shutdown()
}