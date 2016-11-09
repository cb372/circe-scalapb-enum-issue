import org.scalatest.{FlatSpec, Matchers}
import io.circe._
import io.circe.parser._

import protobuf.event.EventType

class CirceSpec extends FlatSpec with Matchers {

  it should "decode an enum" in {
    import io.circe.generic.extras.semiauto.deriveEnumerationDecoder
    implicit val decoder: Decoder[EventType] = deriveEnumerationDecoder[EventType]
    val json = parse(""" "DELIVERED" """).right.get
    json.as[EventType] should be(Right(EventType.DELIVERED))
  }

}
