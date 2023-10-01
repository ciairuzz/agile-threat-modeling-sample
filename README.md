# agile-threat-modeling-sample
Create a threat model that can live within your code repository using Threagile - Agile Threat Modeling Toolkit https://threagile.io/.
Threat Modeling will part of our definition of done, it would be great to adopt agile principles for it Threat Modeling Manifesto https://www.threatmodelingmanifesto.org/ and experiment with tools that allows going beyond pen and paper or a standard designer tool, plus leveraging CI technologies to keep security design up to date along with the product features.

To generate report and diagrams

`threagile -model /app/work/threagile.yaml -output /app/work -verbose`

the report will include some risks accordingly to the provided information.
Not all will apply but is recommended to review them
It is possible to use macros that will help in updating the model
E.g. adding a vault to store secret if we forgot to mention

`threagile -execute-model-macro add-vault -model /app/work/threagile.yaml`

This might mitigate risks and also flag new ones!

Interesting macro to add the build pipeline
`threagile -execute-model-macro add-build-pipeline -model /app/work/threagile.yaml`

