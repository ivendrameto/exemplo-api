
## Tasks

### 1. Criar API de CRUD
Incluir um CRUD de usuários no micrservico de estagio incluindo também uma operação de bloquear e desbloquear.

Suplementação TI
```
Contexto: /estagio
Controller: UserController ("/v1/users")

GET /                       - list all
GET /{id}                   - detalhe
POST /                      - incluir
PUT /{id}                   - alterar
DELETE /{id}                - excluir (inativar)
PATCH /{id}/bloquear
PATCH /{id}/desbloquear
``` 

### Sucessos
Verbo | Body | HTTP Status
----- | ----- | ----- 
DELETE | não | 204
GET | sim | 200
POST | sim | 201
PUT | sim | 200
PATCH | sim | 200