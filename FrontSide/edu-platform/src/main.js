import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import VueRouter from 'vue-router'
import router from './router/index.js'
import VueCoreVideoPlayer from 'vue-core-video-player'

Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(VueCoreVideoPlayer)

new Vue({
  vuetify,
  router:router,
  render: h => h(App)
}).$mount('#app')
