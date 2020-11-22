<template>
  <div>
    <section id="content">
      <div class="hero__image slick-initialized slick-slider">
        <div class="slick-list">
          <slick
            class="slick-track"
            id="carousel"
            ref="slick"
            :options="slickOptions"
          >
            <div>
              <img
                class="slick-img"
                alt="img1"
                style="width: 100%; display: inline-block; opacity: 1;"
                src="../assets/images/slider/1.png"
              />
            </div>
            <div>
              <img
                class="slick-img"
                alt="img2"
                style="width: 100%; display: inline-block; opacity: 1;"
                src="../assets/images/slider/2.png"
              />
            </div>
            <div>
              <img
                class="slick-img"
                alt="img3"
                style="width: 100%; display: inline-block; opacity: 1;"
                src="../assets/images/slider/3.png"
              />
            </div>
            <div>
              <img
                class="slick-img"
                alt="img4"
                style="width: 100%; display: inline-block; opacity: 1;"
                src="../assets/images/slider/4.png"
              />
            </div>
          </slick>
        </div>
      </div>

      <div class="hero__text">
        <img src="../assets/images/bannerT.png" />
        <p id="hero_p_text">
          이사를 가야하는데, 어느 지역으로 가야하는지 모르겠다구요?<br />
          우리 Happy House가 도와드릴게요!!<br />
          함께 가실까요?<br />
        </p>
        <a href=""><img id="hero_btn" src="../assets/images/button.png"/></a>
      </div>

      <div class="SYH">
        <p class="title">Search Your House</p>
        <p class="sub_text">
          관심있는 매물이 있으신가요?<br />
          Happy House와 함께 실거래가를 찾아볼까요?
        </p>
        <form>
          <input
            id="syhtxt"
            type="text"
            placeholder="아파트 / 주택 실거래가 검색"
          />
          <input id="syhsubmit" type="submit" value="검색" />
        </form>
      </div>

      <div class="RH">
        <p class="title">Recommend House</p>
        <p class="sub_text">
          이번주 많은 사람들이 관심을 가진 집은 어디일까요??<br />
          실거래가로 확인해보세요.
        </p>
        <img src="../assets/images/RH1.png" />
        <img src="../assets/images/RH2.png" />
        <img src="../assets/images/RH3.png" />
      </div>
    </section>
  </div>
</template>

<script>
import Slick from "vue-slick";

export default {
  name: "Index",
  components: {
    Slick
  },
  data() {
    return {
      slickOptions: {
        slidesToShow: 1,
        dots: false,
        infinite: true,
        speed: 300,
        autoplay: true,
        autoplaySpeed: 4000,
        arrows: false
      }
    };
  }
};
</script>

<style>
#content {
  position: relative;
}

.hero__image .slick-list .slick-img {
  height: 600px;
}

.hero__text {
  position: absolute;
  top: 100px;
  left: 70px;
}

#hero_p_text {
  background-color: rgba(255, 255, 255, 0.3);
  margin-left: 10px;
  font-size: 18px;
  line-height: 30px;
  font-weight: bold;
}

#hero_btn {
  margin-top: 20px;
  margin-left: 10px;
}

.SYH {
  margin-top: 100px;
  margin-bottom: 50px;
  text-align: center;
}

.SYH .title {
  font-size: 25px;
  font-weight: bold;
  margin-bottom: 20px;
}

.SYH .sub_text {
  font-size: 18px;
  line-height: 25px;
}

.SYH form {
  margin-top: 50px;
}

#syhtxt {
  width: 500px;
  height: 40px;
  font-size: 16px;
  border-color: #ffb900;
  border-radius: 5px;
  margin-right: 10px;
}

#syhsubmit {
  width: 80px;
  height: 40px;
  font-size: 16px;
  color: #fff;
  border-radius: 5px;
  border-color: #ffb900;
  background-color: #ffb900;
  cursor: pointer;
}

hr {
}

.RH {
  margin-top: 100px;
  margin-bottom: 50px;
  text-align: center;
}

.RH .title {
  font-size: 25px;
  font-weight: bold;
  margin-bottom: 20px;
}

.RH .sub_text {
  font-size: 18px;
  line-height: 25px;
}

.RH img {
  cursor: pointer;
}

#carousel .slick-list {
  border-radius: 12px;
  overflow: hidden;
}

#carousel .slick-slide {
  float: left;
  height: 100%;
  min-height: 1px;
}
</style>
