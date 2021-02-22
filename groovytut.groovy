class GroovyTut {

       static void main(String[] args) {
              println('Hello World')

              def age = 'Dog'
              println(age)
              age = 40
              println(age)
              age += 1
              println(age)
              age += 0.1
              println(age)
              age += 0.1
              println(age)
              age = age.multiply(0.1)
              println(age)

              println(Integer.MAX_VALUE)
              println(Integer.MIN_VALUE)
              println(Long.MAX_VALUE)
              println(Long.MIN_VALUE)
              println(Float.MAX_VALUE)
              println(Float.MIN_VALUE)

              println(Double.NaN)

              println('I am ${age}')
              println("I am ${age}")
              println('''
              I am ${age}
              ''')

              def name = 'Freddie'

              println("go by ${name[0..3]}")
              for (c : name) {
                     println("'${c}' : index = ${name.indexOf(c)}")
              }

       }

}
