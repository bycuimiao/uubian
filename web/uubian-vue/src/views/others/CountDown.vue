<template>
  <div>

    <div id="page">
      <nav class="fh5co-nav" role="navigation">
        <div class="container">
          <div class="row">
            <div class="col-xs-12 text-center">
              <div id="fh5co-logo"><a href="index.html">UUBIAN<strong>.</strong></a></div>
            </div>
          </div>
        </div>
      </nav>

      <header id="fh5co-header" class="fh5co-cover" role="banner"
              data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
          <div class="row">
            <div class="col-md-8 col-md-offset-2 text-center">
              <div class="display-t">
                <div class="display-tc animate-box" data-animate-effect="fadeIn">
                  <h1>网站即将上线！</h1>
                  <h2>一起约辩</h2>
                  <div class="simply-countdown simply-countdown-one"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </header>
    </div>
  </div>
</template>
<script>
  export default {
    data () {
      return {
        countDownNum: {
          day: 0,
          hour: 0,
          minute: 0,
          second: 0
        }
      }
    },
    components: {},
    computed: {},
    methods: {

      // 1.前面补0
      addZreo (val) {
        return val < 10 ? '0' + val : val
      },

      getMyTime () {
        var startDate = new Date()
        var endDate = new Date('2018/6/17 11:15:00')
        var countDown = (endDate.getTime() - startDate.getTime()) / 1000
        var day = parseInt(countDown / (24 * 60 * 60))
        var h = parseInt(countDown / (60 * 60) % 24)
        var m = parseInt(countDown / 60 % 60)
        var s = parseInt(countDown % 60)
        this.countDownNum.day = day
        this.countDownNum.hour = h
        this.countDownNum.minute = m
        this.countDownNum.second = s
      },
      created () {
      },
      activated () {
      },
      deactivated () {
      },
      mounted () {
        setTimeout(() => {
          this.getMyTime()
        }, 500)
      }
    }
  }
</script>
<style src="../../res/css/others/style.css"></style>
<style scoped>

</style>
