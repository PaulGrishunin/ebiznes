// @GENERATOR:play-routes-compiler
// @SOURCE:/home/paul/ebiznes/conf/routes
// @DATE:Mon Aug 17 23:07:44 MSK 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
