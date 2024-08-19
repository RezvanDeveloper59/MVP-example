package ir.rezvandeveloper.daneshjooyar.ext

interface OnBindData {

    fun getData(entity: Int) {}

    fun getDataHome(entity: Int) {}

    fun getDataAlmentor(id: Int, sarFasl: String) {}

}