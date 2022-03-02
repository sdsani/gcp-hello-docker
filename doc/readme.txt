Spring boot guide
=================
https://spring.io/guides/gs/spring-boot-docker/
https://spring.io/guides/topicals/spring-boot-docker/
https://tomgregory.com/automating-docker-builds-with-gradle/

https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#build-image

3 possible options for build
============================
1. Using spring boot plugin
	gradlew bootBuildImage

2. Using docker command (this would require Dockerfile) 
	docker build -t sdsani/hello-docker .
3. If you are running build and Jar separately (this would require Dockerfile also v2) 
	docker build --build-arg JAR_FILE=build/libs/*.jar -t sdsani/sds-sb-docker .
	docker build -f Dockerfile_v0 -t sdsani/sds-sb-docker .

DockerFile bestPractce
======================
https://docs.docker.com/develop/develop-images/dockerfile_best-practices/

Run container
=============
docker run -p 8080:8080 sdsani/sds-sb-docker


mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
docker build --build-arg DEPENDENCY=build/dependency -t sdsani/sds-sb-docker .

gradlew bootBuildImage --imageName=sdsani/sds-sb-docker
docker push sdsani/sds-sb-docker

docker run -p 8080:8080 sdsani/sds-sb-docker
docker run -p 8080:8080 -it --name sds-sb-docker sdsani/sds-sb-docker
docker run -e "SPRING_PROFILES_ACTIVE=production" -p 8080:8080 -t sdsani/sds-sb-docker

Once you have a docker image created and pushed to docker repo, following could be used to push it to a GKE container.

gcloud container clusters get-credentials my-cluster --region us-central1-a --project my-kuberneties-project-323716
kubectl create deployment sds-sb-docker --image=sdsani/sds-sb-docker

