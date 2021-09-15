cmd /c gcloud container clusters create-auto my-auto-cluster --region us-central1 --project=my-kuberneties-project-323716
cmd /c gcloud config set container/cluster my-auto-cluster
kubectl create deployment sds-sb-docker --image=sdsani/sds-sb-docker
kubectl expose deployment sds-sb-docker --type=LoadBalancer --port=8080
