package object Anagramas {

  import scala.annotation.tailrec

  type Palabra = String
  type Frase = List[Palabra]
  type Occurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List("cosas", "como", "yo", "y", "ocasos", "oca", "cayo", "mocosos", "roca", "moco", "sos")

  def lOcPal(p: Palabra): Occurrencias = {
    p.toLowerCase
      .groupBy(identity)
      .map { case (char, occurrences) => (char, occurrences.length) }
      .toList
      .sorted
  }

  def lOcFrase(f: Frase): Occurrencias = {
    val fraseCompleta = f.mkString("")
    lOcPal(fraseCompleta)
  }

  lazy val diccionarioPorOcurrencias: Map[Occurrencias, List[Palabra]] = {
    diccionario.groupBy(lOcPal)
  }

  def anagramasDePalabra(pal: Palabra): List[Palabra] = {
    val ocurrenciasPalabra = lOcPal(pal)
    diccionarioPorOcurrencias.getOrElse(ocurrenciasPalabra, Nil)
  }

  def combinaciones(lOcurrencias: Occurrencias): List[Occurrencias] = {
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

  def complemento(lOc: Occurrencias, slOc: Occurrencias): Occurrencias = {
    @tailrec
    def loop(remL1: Occurrencias, remL2: Occurrencias, builtAccRev: Occurrencias): Occurrencias = (remL1, remL2) match {
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
        } else { // c1 > c2
          loop(remL1, t2, builtAccRev)
        }
    }
    loop(lOc, slOc, Nil)
  }

  def anagramasDeFrase(frase: Frase): List[Frase] = {
    val fraseOcc = lOcFrase(frase)

    def encontrarAnagramasRec(ocurrenciasRestantes: Occurrencias): List[Frase] = {

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