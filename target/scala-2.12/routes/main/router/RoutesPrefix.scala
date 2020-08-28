// @GENERATOR:play-routes-compiler
// @SOURCE:/home/paul/ebiznes/conf/routes
// @DATE:Fri Aug 28 21:55:45 MSK 2020


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
