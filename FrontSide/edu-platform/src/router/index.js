import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginPage from '../components/SignInPage.vue'
import NoticeDetail from '../components/NoticeDetail.vue'
import NoticeAdd from '../components/NoticeRegister.vue'
import NoticeList from '../components/NoticeList.vue'
import LearningRate from '../components/LearningRate.vue'
import MainPage from '../components/MainPage.vue'


Vue.use(VueRouter)


const route = [
  {
    path: '/',
    component: MainPage,
  },
  {
    path: '/login',
    component: LoginPage
  },
  {
    path: '/noticeDetail',
    component: NoticeDetail
  },
  {
    path: '/noticeRegister',
    component: NoticeAdd,
  },
  {
    path: '/noticeList',
    component: NoticeList,
  },
  {
    path: '/learningRate',
    component: LearningRate,
  },

  //   {
  //     path:'/loginProject',
  //     component:LoginPage,
  //     name:'login'
  //   },

  //   {
  //     path:'/main',
  //     component:MainPage,
  //     name:'main',
  //     props:true,
  //     children:[
  //       {path:'groupdetail',
  //   name:'groupdetail',
  //   component:MenuGroupDetail,
  //   props:true,
  // },
  //       {
  //         path:'list',
  //         name:'list',
  //         component:MenuList
  //       },
  //       {
  //         path:'admin',
  //         component:MenuManager,
  //         name:'admin',
  //         props:true,
  //       },
  //       {
  //         path:'analytic',
  //         name:'analytic',
  //         component:MenuAnalytic
  //       },
  //       {
  //         path:'group',
  //         name:'group',
  //         component:MenuGroup,
  //         children:[

  //         ]
  //       },
  //       {
  //         path:'push',
  //         name:'push',
  //         component:MenuPush
  //       },

  //     ]
  //   },
  //   {
  //     path:'/initProject',
  //     component:InitialPage,
  //     name:'init'
  //   }
];


const router = new VueRouter({
  // mode: 'history',
  routes: route
})

export default router