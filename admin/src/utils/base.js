const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmd5v2l/",
            name: "ssmd5v2l",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "Science期刊投稿管理系统"
        } 
    }
}
export default base
