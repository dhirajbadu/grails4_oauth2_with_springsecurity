package java_8

import grails.gorm.transactions.Transactional

@Transactional
class ParallelStreamVSStreamApiService {

    def serviceMethod() {

    }

    def streamApiLoop(List<Integer> integerList){
        def startTime = System.currentTimeMillis()
        println("------------streamApiLoop Start--------------")
        integerList.stream().forEach {print(it)}
        def endTime = System.currentTimeMillis()
        println("------------streamApiLoop End--------------")
        println("------------Total Time---${endTime-startTime}")
    }

    def parallelStreamApiLoop(List<Integer> integerList){
        def startTime = System.currentTimeMillis()
        println("------------parallelStreamApiLoop Start--------------")
        integerList.parallelStream().forEach {print(it)}
        def endTime = System.currentTimeMillis()
        println("------------parallelStreamApiLoop End--------------")
        println("------------Total Time ${endTime-startTime}--------------")
    }
}
