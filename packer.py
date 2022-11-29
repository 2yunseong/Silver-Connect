from models.train import clf

from bento_service import LGBMClassifier
# # Create a iris classifier service instance
lgbm_classifier_service = LGBMClassifier()

# # Pack the newly trained model artifact
lgbm_classifier_service.pack('model', clf)
bento_model = bentoml.lightgbm.save_model("model", y_pred)
# # Save the prediction service to disk for model serving
saved_path = lgbm_classifier_service.save()