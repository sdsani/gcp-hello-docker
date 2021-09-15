cmd /c gcloud container clusters create my-cluster --zone us-central1-a --num-nodes=1 --project=my-kuberneties-project-323716
cmd /c gcloud config set container/cluster my-cluster
kubectl create deployment sds-sb-docker --image=sdsani/sds-sb-docker
kubectl expose deployment sds-sb-docker --type=LoadBalancer --port=8080
