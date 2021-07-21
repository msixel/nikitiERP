curl -d '{"code": "BR", "name": "Brasil"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/countries

curl -d '{"code": "RJ",  "name": "Rio de Janeiro", "country": {"id":"1"} }' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/provinces

curl -d '{"name": "Rio de Janeiro", "description":"Capital", "province": {"id":"2"} }' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/cities
curl -d '{"name": "Niteroi", "description":"Papa-goiabas", "province": {"id":"2"} }' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/cities

curl -d '{"name": "Centro", "description":"Centro do Rio de Janeiro", "city": {"id":"3"} }' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/neighborhoods
curl -d '{"name": "Centro", "description":"Centro de Niteroi", "city": {"id":"4"} }' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/neighborhoods

curl -d '{"name": "Encarregado"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/jobpositions
curl -d '{"name": "Assistente Administrativo"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/jobpositions
curl -d '{"name": "Auxiliar de Portaria"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/jobpositions
curl -d '{"name": "Auxiliar de Servicos Gerais"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/jobpositions

curl -d '{"name": "Escala A1", "description": "SEG. A SAB. 06:00 - 14:20"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/schedules
curl -d '{"name": "Escala A2", "description": "SEG. A SAB. 07:00 - 15:20"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/schedules
curl -d '{"name": "Escala A3", "description": "SEG. A SAB. 07:30 - 16:30"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/schedules
curl -d '{"name": "Escala A4", "description": "SEG. A SAB. 09:00 - 17:20"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/schedules
curl -d '{"name": "Escala A5", "description": "SEG. A SAB. 14:00 - 22:00"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/schedules
curl -d '{"name": "Escala A5", "description": "SEG. A SAB. 18:00 - 02:00"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/schedules
curl -d '{"name": "Escala B1", "description": "SEG. A SEX. 07:30 - 16:30"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/schedules
curl -d '{"name": "Escala B2", "description": "SEG. A SEX. 08:00 - 16:20"}' -H "Content-Type: application/json" -X POST http://localhost:8080/niki/rest/schedules

