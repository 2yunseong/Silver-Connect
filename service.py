import pandas as pd

from bentoml import artifacts, api, BentoService
from bentoml.adapters import DataframeInput
from bentoml.frameworks.sklearn import SklearnModelArtifact

# retrieve metadata with `bentoml.models.get`:
bento_model = bentoml.models.get("lightgbm:latest")

# `load` the model back in memory:
loaded_model = bentoml.lightgbm.load_model("lightgbm")

# Run a given model under `Runner` abstraction with `to_runner`
# input_data = pd.from_csv("/path/to/csv")
runner = bentoml.lightgbm.get("lightgbm:latest").to_runner()

@env(infer_pip_packages=True)
@artifacts([LightGBMModelArtifact('model')])
class LGBMClassifier(BentoService):
    @api(input=DataframeInput(), batch=True)
    def predict(self, df: pd.DataFrame):
        run = runner.run(df)
#         runner.init_local()
        """
        An inference API named `predict` with Dataframe input adapter, which codifies
        how HTTP requests or CSV files are converted to a pandas Dataframe object as the
        inference API function input
        """
        return run