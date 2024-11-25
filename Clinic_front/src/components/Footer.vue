<template>
    <div class="footer">
      <div class="footer__logo__block">
        <div class="footer__logo">
          <img src="../assets/img/snake.svg" alt="Logo" />
          <div class="footer__logo__text">
            Для тех, кто ценит репутацию, здоровье и время.
          </div>
        </div>
        <div class="footer__logo__twitter">
          <a href="">
            <img src="../assets/img/twitter.svg" alt="Logo" />
          </a>
          <a href="">
            <img src="../assets/img/in.svg" alt="Logo" />
          </a>
        </div>
      </div>
  
      <div class="footer__contact">
        <h3>Контакты</h3>
        <p class="address">1 ул. Ленина, Москва 111201</p>
        <p class="email">contact@doctor.com</p>
        <p class="тел">(123) 456 - 7890</p>
      </div>
    </div>
</template>

<script>
export default {
  name: 'FooterApp',
};
</script>
<style lang="css" scoped>
.link {
  text-decoration: none;
  color: rgba(77, 80, 83, 1);
}
.link:hover {
  color: rgb(227, 46, 119);
}
.footer {
  display: flex;
  justify-content: space-evenly;
  gap: 20vw;
}
.footer__logo {
  display: flex;
  justify-content: space-around;
  align-items: center;
  justify-content: left;
  gap: 10px;
}
.footer__logo__block {
  /* width: 350px; */
  display: flex;
  flex-direction: column;
  align-items: left;
  gap: 20px;
}
.footer__logo__text {
  font-family: Jost;
  font-size: 18px;
  font-weight: 400;
  line-height: 33px;
  letter-spacing: 0.01em;
  text-align: left;
}
.footer__logo__twitter {
  display: flex;
  justify-content: left;
  gap: 50px;
}

.footer__contact {
  display: flex;
  flex-direction: column;
  align-items: left;
  font-family: DM Serif Display;
  font-size: 18px;
  font-weight: 400;
  line-height: 31px;
  letter-spacing: 0em;
  text-align: left;
  gap: 8px;
}
</style>
