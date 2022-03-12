package com.kodatos.bookmark.bookshelf

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.kodatos.shared.domain.common.SavedBook
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun BookshelfScreen(viewModel: BookshelfScreenViewModel = hiltViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (button, bookshelf) = createRefs()
            ExpandIcon(modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
            ) {
                viewModel.onExpandIconClick()
            }
        }
    }
}

@Composable
private fun ExpandIcon(modifier: Modifier, onClick: () -> Unit) {
    Surface(
        modifier = modifier then Modifier
            .wrapContentSize()
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(bottomStart = 8.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowDropDown,
            contentDescription = "Expanded",
            modifier = Modifier
                .padding(8.dp)
                .size(24.dp, 24.dp),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
private fun Bookshelf(
    modifier: Modifier,
    bookList: List<SavedBook>,
    onBookClick: (SavedBook) -> Unit
) {

}