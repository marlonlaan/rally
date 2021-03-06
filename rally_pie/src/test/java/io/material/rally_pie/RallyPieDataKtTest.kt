package io.material.rally_pie

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.MockitoAnnotations

/**
 * Created by lin min phyo on 2019-07-31.
 */
class RallyPieDataKtTest {

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `Convert 90 90 90 90`() {

        val piePortions = mutableListOf<RallyPiePortion>()

        piePortions.add(RallyPiePortion(anyString(), 50f, anyInt()))
        piePortions.add(RallyPiePortion(anyString(), 50f, anyInt()))
        piePortions.add(RallyPiePortion(anyString(), 50f, anyInt()))
        piePortions.add(RallyPiePortion(anyString(), 50f, anyInt()))


        val expected = listOf(
            RallyPieRenderData(anyString(), -90f + 1f, 90f - 1f, anyInt()),
            RallyPieRenderData(anyString(), 0f + 1f, 90f - 1f, anyInt()),
            RallyPieRenderData(anyString(), 90f + 1f, 90f - 1f, anyInt()),
            RallyPieRenderData(anyString(), 180f + 1f, 90f - 1f, anyInt())
        )

        assertThat(piePortions.toPoints(200f)).containsExactlyElementsIn(expected)
    }


    @Test
    fun `Convert 120 120 120`() {

        val piePortions = mutableListOf<RallyPiePortion>()

        piePortions.add(RallyPiePortion(anyString(), 30f, anyInt()))
        piePortions.add(RallyPiePortion(anyString(), 30f, anyInt()))
        piePortions.add(RallyPiePortion(anyString(), 30f, anyInt()))

        val expected = listOf(
            RallyPieRenderData(anyString(), -90f + 1f, 120f - 1f, anyInt()),
            RallyPieRenderData(anyString(), -90f + 120f + 1f, 120f - 1f, anyInt()),
            RallyPieRenderData(anyString(), -90f + 240f + 1f, 120f - 1f, anyInt())
        )

        assertThat(piePortions.toPoints(90f)).containsExactlyElementsIn(expected)
    }

    @Test
    fun `Convert Only one point`() {
        val piePortions = mutableListOf<RallyPiePortion>()
        piePortions.add(RallyPiePortion(anyString(), 200f, anyInt()))


        val expected = listOf(
            RallyPieRenderData(anyString(), -90f + 1f, 360f - 1f, anyInt())
        )

        assertThat(piePortions.toPoints(200f)).containsExactlyElementsIn(expected)
    }
}