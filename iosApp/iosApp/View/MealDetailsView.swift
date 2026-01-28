//
// Created by Anton Kasarin on 26/01/2026.
//

import SwiftUI
import Shared

struct MealDetailsView: View {
    @ObservedObject private(set) var viewModel: MealDetailsViewModel

    var body: some View {
        VStack {
            AsyncImage(url: URL(string: viewModel.detailsModel?.thumbnailString ?? "")) { image in
                image.resizable()
                    .aspectRatio(contentMode: .fill)
            } placeholder: {
                ProgressView()
            }
            .frame(width: 200, height: 200)
            .clipShape(RoundedRectangle(cornerRadius: 8))
        }
    }
}