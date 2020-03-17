# HOW TO INSTALL parking-app

### Requirements
To start project you need:
 - jdk >= 8
 - docker
 - docker-compose
 
### Step 1. 
Clone project and enter project directory
```
git clone https://github.com/helycopternicht/parking.git
cd parking
```

### Step 2. 
Setup database. Please be sure that you have no another app on 5432 port
```
docker-compose up -d
docker-compose ps
```

### Step 3.
Build application
```
chmod 777 mvnw
./mvnw package
```

### Step 4.
Start application.
```
java -jar target/parking-0.0.1-SNAPSHOT.jar
```

We've done setuping application.Instruction requires linux based OS. If you use another OS may need some changes.

### Step 5.
You can make api calls to application.

###App use examples:
Create parking
```
curl -d '{"description":"Parking1", "capacity": 10}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/parkings
```

Is here available places
```
curl -i -H "Accept: application/json" -X GET http://localhost:8080/api/parkings/1/has-available-slots
```

Available places count
```
curl -o -H "Accept: application/json" -X GET http://localhost:8080/api/parkings/1/available-slots-count
```

To made parking place busy
```
curl -o -H "Accept: application/json" -X POST http://localhost:8080/api/parkings/1/sensors/1/busy
```

To made parking place free
```
curl -o -H "Accept: application/json" -X POST http://localhost:8080/api/parkings/1/sensors/1/free
```
