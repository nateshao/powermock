2020/7/12--2020/7/16
[mockito官网](https://www.javadoc.io/doc/org.mockito/mockito-core/2.7.17/org/mockito/Mockito.html)
## 如何学习powermock (熟悉，了解，熟练，精通)

1）powermock是什么，为什么会有这个，用这个的好处是什么？（计划今天上午完成）
2）powermock如何写demo（@Spy,@SpyBean,@Mock,@MockBean）（计划今天下午去完成）
3）powermock如何结合Spring去写demo，powermock结合项目去上手（计划今天下午和明天早上去完成）
4）powerMock如何结合mvc去写demo，powermock结合mvc去上手项目（计划今天下午和明天早上去完成）
5）powermck如何结合项目去解决问题。

---

1. powermock是什么，为什么会有这个，用这个的好处是什么？

1. 在我们开发的app的时候，可能会出现一些逻辑问题是测试人员测试不到的，或者在测试前需要自测的时候，希望程序自动执行，这时候就需要使用单元测试的。使用单元测试，就会需要模拟一些类或者变量，这时我们就需要使用PowerMock。

2. **PowerMock是Java流行的一种Mock框架**，**用这个的好处是**使用Mock技术能让我们隔离外部依赖以便对我们自己的业务逻辑代码进行单元测试，在编写单元测试时，不需要再进行繁琐的初始化工作，在需要调用某一个接口时，直接模拟一个假方法，并任意指定方法的返回值。    

3. PowerMock则在Mockito原有的基础上做了扩展，通过修改类字节码并使用自定义ClassLoader加载运行的方式来实现mock静态方法、final方法、private方法、系统类的功能。Mockito的工作原理是通过创建依赖对象的proxy，所有的调用先经过proxy对象，proxy对象拦截了所有的请求再根据预设的返回值进行处理。

4. 从两者的项目结构中就可以看出，PowerMock直接依赖于Mockito，所以如果项目中已经导入了PowerMock包就不需要再单独导入Mockito包，如果两者同时导入还要小心PowerMock和Mockito不同版本之间的兼容问题。

---

![mockito例子](https://atom-nateshao.oss-cn-shenzhen.aliyuncs.com/img/mockito.png)

![spy](https://atom-nateshao.oss-cn-shenzhen.aliyuncs.com/img/spy.png)

![buzou](https://atom-nateshao.oss-cn-shenzhen.aliyuncs.com/img/buzou.png)

#### @Spy,@SpyBean,@Mock,@MockBean

- [`spy()`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#spy-T-)/ [`@Spy`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Spy.html)：部分模拟，实际方法被调用，但仍然可以进行验证和存根。**会真的去执行**
- `mock()`/ `@Mock`：创建模拟，**不是会真的去执行**
- （可选）通过[`Answer`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/stubbing/Answer.html)/ 指定其行为方式[`MockSettings`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/MockSettings.html)
  - [`when()`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#when-T-)/ [`given()`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/BDDMockito.html#given-T-)指定模拟行为
- 如果提供的答案不符合您的需求，请自己编写一个扩展[`Answer`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/stubbing/Answer.html)界面
- [`@InjectMocks`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/InjectMocks.html)：**自动注入带有`@Spy`或注释的模拟/间谍字段`@Mock`**
- `verify()`：检查使用给定参数调用的方法
- 可以使用灵活的参数匹配，例如通过 [`any()`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/ArgumentMatchers.html#any--)
  - 或捕获[`@Captor`](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Captor.html)代替使用的参数
- 尝试使用[BDDMockito的](http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/BDDMockito.html)行为驱动开发语法

**@Spy和** **@SpyBean的区别，** **@Mock** **和 @MockBean的区别**

1. spy和mock生成的对象不受spring管理 --- **模拟的**

2. spy调用真实方法时，其它bean是无法注入的，要使用注入，要使用SpyBean

3. SpyBean和MockBean生成的对象受spring管理，相当于自动替换对应类型bean的注入，比如@Autowired等注入

4. 在SpringBoot中用**@SpyBean**来表示一个“间谍对象”，允许它的某些方法被模拟，而剩下的方法仍然是真实的方法。

5. @Spy 和 new的区别就是，Spy可以根据你的意愿进行返回处理，new无法做到。

6. `@SpyBean` 包裹着真正的 Bean 装配到了 controller 中，并对特定的行为作出反应。

   需要注意的是，设置 spy 逻辑时不能再使用 `when(某对象.某方法).thenReturn(某对象)` 的语法，而是需要使用 `doReturn(某对象).when(某对象).某方法` 或者 `doNothing(某对象).when(某对象).某方法`。

- @Mock：创建一个Mock。
- **@InjectMocks**：创建一个实例，其余用@Mock（或@Spy）注解创建的mock将被注入到用该实例中。

@Autowird 等方式完成自动注入。在单元测试中，没有启动 spring 框架，此时就需要通过 @ InjectMocks完成依赖注入。@InjectMocks会将带有@Spy 和@Mock 注解的对象尝试注入到被 测试的目标类中。记住下面这两句话即可：

- Usually when you are unit testing, you shouldn't initialize Spring context. So remove Autowiring.
- Usually when you do integration testing, you should use real dependencies. So remove mocking.



## MockMVC、PowerMock集成Spring

![mockmvc](https://atom-nateshao.oss-cn-shenzhen.aliyuncs.com/img/mockmvc.png)














