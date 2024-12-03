package io.knowk.example.feature.home.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.knowk.example.core.designsystem.component.HeadLine
import io.knowk.example.feature.home.ui.model.StoreCardUiModel
import io.knowk.example.feature.home.ui.preview.PreviewUtil
import io.knowk.example.feature.home.ui.section.CardSection
import kotlinx.collections.immutable.PersistentList

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val title by viewModel.title.collectAsStateWithLifecycle()
    val stores by viewModel.stores.collectAsStateWithLifecycle()

    HomeScreen(
        title = title,
        stores = stores,
        onInsertFavoriteStore = viewModel::insertFavoriteStore,
        onDeleteFavoriteStore = viewModel::deleteFavoriteStore,
        modifier = modifier,
    )
}

@Composable
private fun HomeScreen(
    title: String,
    stores: PersistentList<StoreCardUiModel>?,
    onInsertFavoriteStore: (StoreCardUiModel) -> Unit,
    onDeleteFavoriteStore: (StoreCardUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (stores == null) return
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        HeadLine(
            title = title,
            modifier = Modifier
                .padding(horizontal = 20.dp),
        )

        LazyColumn(
            verticalArrangement = spacedBy(12.dp),
            contentPadding = PaddingValues(20.dp),
            modifier = modifier
                .fillMaxSize(),
        ) {
            CardSection(
                stores = stores,
                onInsertFavoriteStore = onInsertFavoriteStore,
                onDeleteFavoriteStore = onDeleteFavoriteStore,
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
)
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            title = "똑똑, 동네 맛집이 도착했어요",
            stores = PreviewUtil.mockStoreCardUiModels(),
            onInsertFavoriteStore = {},
            onDeleteFavoriteStore = {},
        )
    }
}
