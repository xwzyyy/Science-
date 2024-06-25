const menu = {
    list: function () {
        return [
            {
                "backMenu": [
                    {
                    "child": [{
                        "appFrontIcon": "cuIcon-flashlightopen",
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "作者",
                        "menuJump": "列表",
                        "tableName": "zuozhe"
                    }], "menu": "作者管理"
                }, /*{
                    "child": [{
                        "appFrontIcon": "cuIcon-album",
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "编辑部",
                        "menuJump": "列表",
                        "tableName": "bianjibu"
                    }], "menu": "编辑部管理"
                }, */{
                    "child": [{
                        "appFrontIcon": "cuIcon-goods",
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "审稿人",
                        "menuJump": "列表",
                        "tableName": "shengaoren"
                    }], "menu": "审稿人管理"
                }, {
                    "child": [{
                        "appFrontIcon": "cuIcon-goods",
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "稿件类型",
                        "menuJump": "列表",
                        "tableName": "gaojianleixing"
                    }], "menu": "稿件类型管理"
                }],
                "frontMenu": [],
                "hasBackLogin": "是",
                "hasBackRegister": "否",
                "hasFrontLogin": "否",
                "hasFrontRegister": "否",
                "roleName": "管理员",
                "tableName": "users"
            }, {
                "backMenu": [
                    {
                    "child": [{
                        "appFrontIcon": "cuIcon-full",
                        "buttons": ["新增", "查看", "删除", "修改"],
                        "menu": "上传稿件",
                        "menuJump": "列表",
                        "tableName": "shangchuangaojian"
                    }], "menu": "上传稿件管理"
                }, {
                    "child": [{
                        "appFrontIcon": "cuIcon-explore",
                        "buttons": ["查看", "修改"],
                        "menu": "收稿",
                        "menuJump": "列表",
                        "tableName": "shougao"
                    }], "menu": "收稿管理"
                }, {
                    "child": [{
                        "appFrontIcon": "cuIcon-vipcard",
                        "buttons": ["查看", "改稿送审", "改稿回复"],
                        "menu": "改稿通知",
                        "menuJump": "列表",
                        "tableName": "gaigaotongzhi"
                    }], "menu": "改稿通知管理"
                },
/*                    {
                    "child": [{
                        "appFrontIcon": "cuIcon-cardboard",
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "改稿回复",
                        "menuJump": "列表",
                        "tableName": "gaigaohuifu"
                    }], "menu": "改稿回复管理"
                }, */
                    {
                    "child": [{
                        "appFrontIcon": "cuIcon-newshot",
                        "buttons": ["查看", "支付"],
                        "menu": "稿件录用",
                        "menuJump": "列表",
                        "tableName": "gaojianluyong"
                    }], "menu": "稿件录用管理"
                }, /*
                {
                  "child": [{
                        "appFrontIcon": "cuIcon-vip",
                        "buttons": ["查看"],
                        "menu": "稿件刊载",
                        "menuJump": "列表",
                        "tableName": "gaojiankanzai"
                    }], "menu": "稿件刊载管理"
                }*/
                ],
                "frontMenu": [],
                "hasBackLogin": "是",
                "hasBackRegister": "是",
                "hasFrontLogin": "否",
                "hasFrontRegister": "否",
                "roleName": "作者",
                "tableName": "zuozhe"
            }, {
                "backMenu": [
                    {
                    "child": [{
                        "appFrontIcon": "cuIcon-full",
                        "buttons": ["查看", "删除", "修改", "收稿", "审核"],
                        "menu": "上传稿件",
                        "menuJump": "列表",
                        "tableName": "shangchuangaojian"
                    }], "menu": "上传稿件管理"
                },
        /*            {
                    "child": [{
                        "appFrontIcon": "cuIcon-explore",
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "收稿",
                        "menuJump": "列表",
                        "tableName": "shougao"
                    }], "menu": "收稿管理"
                }, */
                   /* {
                    "child": [{
                        "appFrontIcon": "cuIcon-cardboard",
                        "buttons": ["查看", "审核"],
                        "menu": "改稿回复",
                        "menuJump": "列表",
                        "tableName": "gaigaohuifu"
                    }], "menu": "改稿回复管理"
                }*/
                ],
                "frontMenu": [],
                "hasBackLogin": "是",
                "hasBackRegister": "否",
                "hasFrontLogin": "是",
                "hasFrontRegister": "是",
                "roleName": "编辑部",
                "tableName": "bianjibu"
            }, {
                "backMenu": [
                    {
                    "child": [{
                        "appFrontIcon": "cuIcon-full",
                        "buttons": ["新增", "查看", "删除", "修改"],
                        "menu": "上传稿件",
                        "menuJump": "列表",
                        "tableName": "shangchuangaojian"
                    }], "menu": "上传稿件管理"
                },
                    {
                    "child": [{
                        "appFrontIcon": "cuIcon-explore",
                        "buttons": ["查看", "改稿通知", "审核", "稿件录用"],
                        "menu": "收稿",
                        "menuJump": "列表",
                        "tableName": "shougao"
                    }], "menu": "收稿管理"
                }, /*{
                    "child": [{
                        "appFrontIcon": "cuIcon-vipcard",
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "改稿通知",
                        "menuJump": "列表",
                        "tableName": "gaigaotongzhi"
                    }], "menu": "改稿通知管理"
                },*/
                    /*{
                    "child": [{
                        "appFrontIcon": "cuIcon-cardboard",
                        "buttons": ["查看", "修改", "删除"],
                        "menu": "改稿回复",
                        "menuJump": "列表",
                        "tableName": "gaigaohuifu"
                    }], "menu": "改稿回复管理"
                }, */
                    {
                    "child": [{
                        "appFrontIcon": "cuIcon-newshot",
                        "buttons": ["查看", "修改", "删除", "稿件刊载"],
                        "menu": "稿件录用",
                        "menuJump": "列表",
                        "tableName": "gaojianluyong"
                    }], "menu": "稿件录用管理"
                },
          /*          {
                    "child": [{
                        "appFrontIcon": "cuIcon-vip",
                        "buttons": ["查看", "修改", "删除", "支付"],
                        "menu": "稿件刊载",
                        "menuJump": "列表",
                        "tableName": "gaojiankanzai"
                    }], "menu": "稿件刊载管理"
                }*/
                ],
                "frontMenu": [],
                "hasBackLogin": "是",
                "hasBackRegister": "否",
                "hasFrontLogin": "是",
                "hasFrontRegister": "是",
                "roleName": "审稿人",
                "tableName": "shengaoren"
            }]
    }
}
export default menu;
