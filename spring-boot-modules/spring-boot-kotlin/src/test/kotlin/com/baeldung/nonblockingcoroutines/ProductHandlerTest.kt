package com.baeldung.nonblockingcoroutines

import com.baeldung.nonblockingcoroutines.config.RouterConfiguration
import com.baeldung.nonblockingcoroutines.handlers.ProductsHandler
import com.baeldung.nonblockingcoroutines.model.Product
import com.baeldung.nonblockingcoroutines.repository.ProductRepositoryRelationalDatabase
import kotlinx.coroutines.flow.flowOf
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBodyList
import org.springframework.web.reactive.function.client.WebClient

@WebFluxTest(
    excludeAutoConfiguration = [ReactiveUserDetailsServiceAutoConfiguration::class, ReactiveSecurityAutoConfiguration::class]
)
@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [ProductsHandler::class, RouterConfiguration::class])
class ProductHandlerTest {

    @Autowired
    private lateinit var client: WebTestClient

    @MockBean
    private lateinit var webClient: WebClient

    @MockBean
    private lateinit var productsRepositoryRelationalDatabase: ProductRepositoryRelationalDatabase

    @Test
    fun `get all products`() {
        val productsFlow = flowOf(
          Product(1, "product1", 1000.0F),
          Product(2, "product2", 2000.0F),
          Product(3, "product3", 3000.0F)
        )

        given(productsRepositoryRelationalDatabase.getAllProducts()).willReturn(productsFlow)

        client.get()
          .uri("/v3")
          .exchange()
          .expectStatus()
          .isOk
          .expectBodyList<Product>()
    }
}
