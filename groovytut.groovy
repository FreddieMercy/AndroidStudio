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

              printf('%10s %.2f\n', name, age)
              printf('%-10s %.2f\n', name, age)

              try {
                     print('What is your name? :')
                     def yourName = System.console().readLine().toString()

                     println('Hello ' + yourName + '\n\n')
                     }catch (Exception e) { }

              printf('%10s %.2f\n', [name, age])
              printf('%-10s %.2f\n', [name, age])

              def array = [1, 3, '7', 15.5]
              println(array)
              println(array[2] + array[3]) // str: "7" + "15.5"
              println(array[1] + array[2]) // 后面的cast成前面的

              // def dict = {'a':1, 'b':3.4, 'c':name}

              // println(dict)

              def bitwise = 1 << 3
              println(bitwise)

              def arr2 = [2, 4, 6]

              println(array + arr2) //append
              println(array - arr2)
              println(array - ['7', 15.5])
              println(array - ['7', 15.5] + arr2) //append
              }

       }
