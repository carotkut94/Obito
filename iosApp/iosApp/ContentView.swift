import SwiftUI
import shared

struct Item {
    let uuid = UUID()
    let value: String
}

struct ContentView: View {
    @State private var items = [Item]()
    
    var body: some View {
        ZStack {
            VStack{
                Text("Servers")
                List(self.items, id: \.uuid) { item in
                    Text(item.value)
                }
            }
            
            VStack {
                Spacer()
                HStack {
                    Spacer()
                    Button(action: {
                        self.items.append(Item(value: "Item"))
                    }, label: {
                        Text("+")
                        .font(.system(.largeTitle))
                        .frame(width: 77, height: 70)
                        .foregroundColor(Color.white)
                        .padding(.bottom, 7)
                    })
                    .background(Color.blue)
                    .cornerRadius(38.5)
                    .padding()
                    .shadow(color: Color.black.opacity(0.3),
                            radius: 3,
                            x: 3,
                            y: 3)
                }
            }
        }
    }
}
