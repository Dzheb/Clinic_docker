# Развёртывание (деплой)

## Способ 1
### Компиляция и перезагрузка в run-time для разработки
```
npm run serve -- --port 3000
```

### Компилировать для production
```
npm run build
```
### Для запуска сборки используется статический Node.js файл сервер, для его установки:
npm install -g serve
### -s означает Single-Page Application mode

### для запуска сборки
serve -s dist

## Способ 2
### С помощью Docker
### Необходимые файлы Dockerfile и docker-compose.yml находятся в папке проекта
### поэтому достаточно команд -
docker build -t clinic-front:dev .
### и
docker compose up
### в терминале
