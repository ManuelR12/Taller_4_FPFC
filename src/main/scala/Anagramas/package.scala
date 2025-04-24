package object Anagramas {

  import scala.annotation.tailrec

  type Palabra = String
  type Frase = List[Palabra]
  type Ocurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List("cosas", "como", "yo", "y", "ocasos", "oca", "cayo", "mocosos", "roca", "moco", "sos")

  def lOcPal(p: Palabra): Ocurrencias = {
    p.toLowerCase
      .groupBy(identity)
      .map { case (char, occurrences) => (char, occurrences.length) }
      .toList
      .sorted
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    val fraseCompleta = f.mkString("")
    lOcPal(fraseCompleta)
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    diccionario.groupBy(lOcPal)
  }

  def anagramasDePalabra(pal: Palabra): List[Palabra] = {
    val ocurrenciasPalabra = lOcPal(pal)
    diccionarioPorOcurrencias.getOrElse(ocurrenciasPalabra, Nil)
  }

  def combinaciones(lOcurrencias: Ocurrencias): List[Ocurrencias] = {
    lOcurrencias match {
      case Nil => List(List())
      case (char, count) :: rest =>
        val combsRest = combinaciones(rest)

        val currentOccs = for {
          k <- 1 to count
        } yield List((char, k))

        val combinedWithHead = for {
          headPart <- currentOccs
          restPart <- combsRest
        } yield (headPart ++ restPart).sorted

        combsRest ++ combinedWithHead
    }
  }

  def complemento(lOc: Ocurrencias, slOc: Ocurrencias): Ocurrencias = {
    @tailrec
    def loop(remL1: Ocurrencias, remL2: Ocurrencias, builtAccRev: Ocurrencias): Ocurrencias = (remL1, remL2) match {
      case (Nil, _) => builtAccRev.reverse
      case (l1, Nil) => builtAccRev.reverse ++ l1

      case ((c1, n1) :: t1, (c2, n2) :: t2) =>
        if (c1 < c2) {

          loop(t1, remL2, (c1, n1) :: builtAccRev)
        } else if (c1 == c2) {
          val diff = n1 - n2
          if (diff > 0) {
            loop(t1, t2, (c1, diff) :: builtAccRev)
          } else {
            loop(t1, t2, builtAccRev)
          }
        } else {
          loop(remL1, t2, builtAccRev)
        }
    }
    loop(lOc, slOc, Nil)
  }

  def anagramasDeFrase(frase: Frase): List[Frase] = {
    val fraseOcc = lOcFrase(frase)

    def encontrarAnagramasRec(ocurrenciasRestantes: Ocurrencias): List[Frase] = {

      if (ocurrenciasRestantes.isEmpty) {
        List(List())
      } else {
        val resultados = for {
          subOcc <- combinaciones(ocurrenciasRestantes) if subOcc.nonEmpty // Considera solo subconjuntos no vacíos

          palabra <- diccionarioPorOcurrencias.getOrElse(subOcc, Nil)

          ocurrenciasComplementarias = complemento(ocurrenciasRestantes, subOcc)

          fraseRestante <- encontrarAnagramasRec(ocurrenciasComplementarias)

        } yield {
          palabra :: fraseRestante
        }
        resultados
      }
    }

    encontrarAnagramasRec(fraseOcc)
  }

}