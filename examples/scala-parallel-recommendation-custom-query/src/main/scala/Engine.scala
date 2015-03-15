package org.template.recommendation

import io.prediction.controller.IEngineFactory
import io.prediction.controller.Engine

case class Query(user: String, num: Int, creationYear: Option[Int] = None)
  extends Serializable

case class PredictedResult(itemScores: Array[ItemScore]) extends Serializable

case class ItemScore(item: String, score: Double, creationYear: Option[Int])
  extends Serializable

object RecommendationEngine extends IEngineFactory {
  def apply() =
    new Engine(classOf[DataSource],
      classOf[Preparator],
      Map("als" -> classOf[ALSAlgorithm]),
      classOf[Serving])
}
