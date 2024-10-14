package com.example.myapplication.testing

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class TestingMainViewModelTest{
    private lateinit var mainViewModel: TestingMainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 500.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = TestingMainViewModel(cuboidModel)
    }

    @org.junit.jupiter.api.Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = TestingMainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getVolume()
        Assertions.assertEquals(dummyVolume, volume, 0.0001)
    }

    @org.junit.jupiter.api.Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = TestingMainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val circumference = mainViewModel.getCircumference()
        Assertions.assertEquals(dummyCircumference, circumference, 0.0001)
    }
    @org.junit.jupiter.api.Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = TestingMainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val surfaceArea = mainViewModel.getSurfaceArea()
        Assertions.assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @org.junit.jupiter.api.Test
    fun testMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(cuboidModel).getVolume()
        Assertions.assertEquals(dummyVolume, volume, 0.0001)
    }
    @org.junit.jupiter.api.Test
    fun testMockCircumference() {
        `when`(mainViewModel.getCircumference()).thenReturn(dummyCircumference)
        val circumference = mainViewModel.getCircumference()
        verify(cuboidModel).getCircumference()
        Assertions.assertEquals(dummyCircumference, circumference, 0.0001)
    }
    @org.junit.jupiter.api.Test
    fun testMockSurfaceArea() {
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        Assertions.assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }
}