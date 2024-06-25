import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    // 上传稿件
    import shangchuangaojian from '@/views/modules/shangchuangaojian/list'
    // 稿件刊载
    import gaojiankanzai from '@/views/modules/gaojiankanzai/list'
    // 编辑部
    import bianjibu from '@/views/modules/bianjibu/list'
    // 稿件录用
    import gaojianluyong from '@/views/modules/gaojianluyong/list'
    // 作者
    import zuozhe from '@/views/modules/zuozhe/list'
    // 审稿人
    import shengaoren from '@/views/modules/shengaoren/list'
    // 稿件类型
    import gaojianleixing from '@/views/modules/gaojianleixing/list'
    // 改稿通知
    import gaigaotongzhi from '@/views/modules/gaigaotongzhi/list'
    // 改稿回复
    import gaigaohuifu from '@/views/modules/gaigaohuifu/list'
    // 收稿
    import shougao from '@/views/modules/shougao/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [
        {
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
  ,{
	path: '/shangchuangaojian',
        name: '上传稿件',
        component: shangchuangaojian
  },
        ,{
            path: '/zuozhe',
            name: '作者',
            component: zuozhe
        }
/*      ,{
	path: '/gaojiankanzai',
        name: '稿件刊载',
        component: gaojiankanzai
      }*/
      ,{
	path: '/bianjibu',
        name: '编辑部',
        component: bianjibu
      }
      ,{
	path: '/gaojianluyong',
        name: '稿件录用',
        component: gaojianluyong
      }

      ,{
	path: '/shengaoren',
        name: '审稿人',
        component: shengaoren
      }
      ,{
	path: '/gaojianleixing',
        name: '稿件类型',
        component: gaojianleixing
      }
      ,{
	path: '/gaigaotongzhi',
        name: '改稿通知',
        component: gaigaotongzhi
      }
/*      ,{
	path: '/gaigaohuifu',
        name: '改稿回复',
        component: gaigaohuifu
      }*/
      ,{
	path: '/shougao',
        name: '收稿',
        component: shougao
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
