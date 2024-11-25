# образ node
#FROM node:12.2.0-alpine

# рабочая папка
#WORKDIR /app

# добавление `/app/node_modules/.bin` to $PATH
#ENV PATH /app/node_modules/.bin:$PATH

# установка зависимостей
#COPY package.json /app/package.json
#RUN npm install
#RUN npm install @vue/cli

#EXPOSE 8080
# start
#CMD ["npm", "run", "serve"]
#
#
#FROM node:16 as build-stage
#WORKDIR /app
#COPY package*.json ./
#RUN npm install
#COPY ./ .
#RUN npm run build
#FROM nginx as production-stage
#EXPOSE 3000
#RUN mkdir /app
#COPY nginx.conf /etc/nginx/conf.d/default.conf
#COPY --from=build-stage /app/dist /app
#
#
FROM node:12.2.0-alpine as ui-builder
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json /app/package.json
RUN npm install
RUN npm install -g @vue/cli
COPY . /app
#COPY . .
RUN npm run build
#CMD ["npm", "run", "serve"]
 
FROM nginx
COPY  --from=ui-builder /app/dist /usr/share/nginx/html
# Удаляем существующий файл default.conf
RUN rm -f /etc/nginx/conf.d/default.conf
# Копируем новый default.conf в директорию конфигурации Nginx
COPY ./nginx/conf.d/default.conf /etc/nginx/conf.d/
#
EXPOSE 80
EXPOSE 443
CMD ["nginx", "-g", "daemon off;"]
