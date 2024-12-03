package io.knowk.example.feature.favorite.ui

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.knowk.example.core.designsystem.component.HeadLine
import io.knowk.example.core.model.Store
import io.knowk.example.feature.favorite.R
import io.knowk.example.feature.favorite.ui.preview.PreviewUtil
import io.knowk.example.feature.favorite.ui.section.CardSection
import kotlinx.collections.immutable.PersistentList

@Composable
internal fun FavoriteRoute(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel(),
) {
    val favoriteStores by viewModel.favoriteStores.collectAsStateWithLifecycle()
    FavoriteScreen(
        favoriteStores = favoriteStores,
        onClickFavorite = viewModel::deleteFavoriteStore,
        modifier = modifier,
    )
}

@Composable
private fun FavoriteScreen(
    favoriteStores: PersistentList<Store>,
    onClickFavorite: (Store) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        HeadLine(
            title = stringResource(R.string.favorite_screen_title),
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
                favoriteStores = favoriteStores,
                onClickFavorite = onClickFavorite,
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
)
private fun FavoriteScreenPreview() {
    MaterialTheme {
        FavoriteScreen(
            favoriteStores = PreviewUtil.mockStores(),
            onClickFavorite = {},
        )
    }
}
